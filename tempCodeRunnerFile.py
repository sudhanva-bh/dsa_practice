import random
import pyperclip

n = 8

nums = set()
while len(nums) < n:
    s = ''.join(random.choice('01') for _ in range(n))
    nums.add(s)

nums = list(nums)

# format exactly like ["010","111","001"]
formatted = "[" + ",".join(f'"{x}"' for x in nums) + "]"

pyperclip.copy(formatted)

print("Copied to clipboard:")
print(formatted)