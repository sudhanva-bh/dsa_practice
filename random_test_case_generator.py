import random
import pyperclip

NUM_ARRAYS = 8
MIN_N = 5_000
MAX_N = 50_000
MIN_VAL = 0
MAX_VAL = 50_000

arrays = []

for _ in range(NUM_ARRAYS):
    n = random.randint(MIN_N, MAX_N)
    arr = [random.randint(MIN_VAL, MAX_VAL) for _ in range(n)]
    arrays.append(arr)

# Format as Python code
output = ""
for arr in arrays:
    output += f"{arr},\n"

pyperclip.copy(output)

print(f"Copied {NUM_ARRAYS} arrays to clipboard.")