import random
import pyperclip

def generate() -> str:
    # Random n within constraints
    n = random.randint(1, 10**5)

    # Generate costs
    costs = [random.randint(1, 10**5) for _ in range(n)]

    # Generate coins
    coins = random.randint(1, 10**8)

    return f"{str(costs).replace(' ', '')}\n{coins}"

tests = []

# Small edge case
tests.append("[1]\n1")

# Large edge case
costs = [100000] * 100000
tests.append(f"{str(costs).replace(' ', '')}\n100000000")

# 6 random tests
for _ in range(6):
    tests.append(generate())

all_tests = "\n".join(tests)

pyperclip.copy(all_tests)

print("Copied", len(tests), "test cases to clipboard.")