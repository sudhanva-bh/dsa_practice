import random
import pyperclip

n = random.randint(10 * 10**4, 10**5)
nums = [random.randint(1, n) for _ in range(n)]

pyperclip.copy("[" + ",".join(map(str, nums)) + "]")
print(n)