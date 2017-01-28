# -*- coding: utf-8 -*-
"""
Created on Fri Nov 04 12:06:07 2016
Project Euler Problem #576
@author: gargi chakraborty
"""
import math
import numpy as np
import matplotlib.pyplot as plt
import time

#Hard coded values
circumference = 1

# Get all prime numbers less than n
def is_prime(num):
    for i in range(2, int(math.sqrt(num))+1):
        if num%i == 0:
            return False
    return True

# Return list of primes
def get_all_primes(n):
    list_primes = []    
    for i in range(2, n+1):
        if is_prime(i):           
            list_primes.append(i)
    return list_primes

# Function to compute S
def sum_of_jumps(l, g, d, i=1): 
    #Base case
    if i*l >= d and i*l <= g+d:       
        return i*l
    else: # recursive case
        new_i = i + 1  
        new_d = (new_i*l)//circumference + d%circumference
        return sum_of_jumps(l, g, new_d, new_i)

# Function to compute M
def max_jump_sum(g, d, all_primes):
    m = 0
    for p in all_primes:
        l = math.sqrt(1.0/p)        
        m += sum_of_jumps(l, g, d)
    return m

# Helper function to get valid value of 'd' that gives absolute max
# this can be optimized to better find glo
def max_jump_sum_initiate(n, g):
    all_primes = get_all_primes(n)
    print("all_primes is: ", all_primes)
    min_d = 0.01
    max_d = circumference-g
    result = []
    d_list = np.arange(min_d, max_d, 0.01)
    for d in d_list:
        result.append(max_jump_sum(g, d, all_primes))
    
    plt.plot(d_list, result, '-o')
    return round(max(result), 4)
    

# Main function with tests
#print("M(3, 0.06) = ", max_jump_sum_initiate(3, 0.06))
#start = time.time()
#print("M(3, 0.01) = ", max_jump_sum_initiate(3, 0.001))
#end = time.time()
#print("time elapsed = ", end-start)

print("sum of jumps = ", sum_of_jumps(math.sqrt(1.0/3), 0.001, 0.001))
