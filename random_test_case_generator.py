import random
import pyperclip

n = random.randint(2 * 10**4, 3 * 10**4)

nums = [random.randint(-10**4, 10**4) for _ in range(n)]

nums.sort()

formatted = "[" + ",".join(map(str, nums)) + "]"

pyperclip.copy(formatted)

print("Array copied to clipboard!")