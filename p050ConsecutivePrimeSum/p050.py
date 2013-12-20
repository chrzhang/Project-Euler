import math
import time
"""
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

Author: Christopher Zhang
"""

def genPrimes(limit):
    "Generates an array of indices containing whether or not they are prime up to and including a given limit using a Sieve of Eratosthenes"
    primes = [1] * (limit + 1)
    if (limit < 2):
        print("Please enter a value that is at least 2.")
        return
    primes[0] = 0
    primes[1] = 0
    
    i = 2 # Start at 2
    while (i <= math.sqrt(limit)): # A number will be prime if no factors up to its sqrt have been found that is not == 1
        if (primes[i] == 1):
            j = 2
            while (i * j <= limit):
                primes[i*j] = 0
                j += 1
        i += 1
    return primes

start_time = time.time()
bound = 1000000
primalities = genPrimes(bound)
seqPrime = []

for x in range(0, bound):
    if (primalities[x]): # For each one found
        seqPrime.append(x)

total = 0
count = -1 # Currently unfound
indexFromStart = 0
while(indexFromStart < len(seqPrime)): # Go from ifs = 0 to ifs = # of primes
    thisTotal = 0
    indexAsStart = indexFromStart
    while (indexAsStart < len(seqPrime)): # Go from current = ifs to current = # of primes
        thisTotal += seqPrime[indexAsStart]
        if (thisTotal > bound):
            break # Have exceeded realm of possibility
        elif (((indexAsStart - indexFromStart) > count) and (thisTotal > total) and (primalities[thisTotal])): 
            total = thisTotal # When a new answer has been found in the sum of those that remain (length greater, sum is prime, and is not already found)
            count = indexAsStart - indexFromStart
        indexAsStart += 1
    indexFromStart += 1
print(total)
print ("Running Time:", time.time() - start_time, "seconds")
