# Create simulator
set ns [new Simulator]

# NAM and trace files
set nf [open lab1.nam w]; $ns namtrace-all $nf
set tf [open lab1.tr w]; $ns trace-all $tf

# Finish procedure
proc finish {} {
    global ns nf tf
    $ns flush-trace
    close $nf; close $tf
    exec nam lab1.nam &
    exit 0
}

# Create nodes
set n0 [$ns node]; set n1 [$ns node]
set n2 [$ns node]; set n3 [$ns node]

# Duplex links (bandwidth delay queue)
$ns duplex-link $n0 $n2 200Mb 10ms DropTail
$ns duplex-link $n1 $n2 100Mb 5ms DropTail
$ns duplex-link $n2 $n3 1Mb 1000ms DropTail

# Queue limits
$ns queue-limit $n0 $n2 10
$ns queue-limit $n1 $n2 10

# UDP agents + CBR
foreach {node udp cbr interval pkt} \
    {$n0 udp0 cbr0 0.005 500 $n1 udp1 cbr1 "" "" $n2 udp2 cbr2 "" ""} {

    set $udp [new Agent/UDP]
    $ns attach-agent $node $udp
    set $cbr [new Application/Traffic/CBR]
    $cbr attach-agent $udp
    if {$interval ne ""} {$cbr set packetSize_ $pkt; $cbr set interval_ $interval}
}

# Null sink at n3
set null [new Agent/Null]; $ns attach-agent $n3 $null

# Connect UDP agents to sink
$ns connect $udp0 $null
$ns connect $udp1 $null

# Start traffic
$ns at 0.1 "$cbr0 start"
$ns at 0.2 "$cbr1 start"

# End simulation
$ns at 1.0 "finish"
$ns run
