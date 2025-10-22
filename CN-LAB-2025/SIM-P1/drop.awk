
# BEGIN block: executed once before processing input
BEGIN {
    c = 0;   # Initialize counter for dropped packets
}

{
    # Check if the first column indicates packet drop (d)
    if ($1 == "d") {
        c++;                             # Increment drop counter
        printf("%s\t%s\n", $5, $11);     # Print source node and packet size
    }
}

# END block: executed after processing input
END {
    printf("The number of packets dropped = %d\n", c);  # Print total drops
}
