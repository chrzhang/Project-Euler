import math
import time

"""
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
(i) each of the three terms are prime, and,
(ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?

Author: Christopher Zhang
"""

def isPerm(x, y): # Tells if one int is the permutation of another
    "Returns whether one int is the permutation of another"
    xS = str(x)
    yS = str(y)
    xS = sorted(xS)
    yS = sorted(yS)
    return (xS == yS)

start_time = time.time()
n = 9999 # Highest 4-digit number
primes = [1] * (n+1) # Create a sieve of Eratosthenes

primes[0] = 0 # 0 is not prime
primes[1] = 0 # 1 is not prime

i = 2 # Start at 2
while (i <= math.sqrt(n)): # A number will be prime if no factors up to its sqrt have been found that is not == 1
    if (primes[i] == 1):
        j = 2
        while (i * j <= n):
            primes[i*j] = 0
            j += 1
    i += 1

indexOfPrime = 1019 # The first four-digit prime number, 1019, occurs at index = 1019
# Iterate through all primes
firstFound = -1
while ((indexOfPrime < 3339)):
    if (primes[indexOfPrime]):
        # indexOfPrime is a prime number
        if (primes[indexOfPrime + 3330] and isPerm(indexOfPrime, indexOfPrime+3330)):
            if (primes[indexOfPrime + 6660] and isPerm(indexOfPrime, indexOfPrime)):
                firstFound += 1
                if (firstFound):
                    print(indexOfPrime, indexOfPrime + 3330, indexOfPrime + 6660)
    indexOfPrime += 1

print ("Running Time:", time.time() - start_time, "seconds")
