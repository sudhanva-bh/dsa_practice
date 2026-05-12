import random
import string
import pyperclip

NUM_CASES = 8
STR_COUNT = 10**4

cases = []

for _ in range(NUM_CASES):
    arr = []

    for _ in range(STR_COUNT):
        length = random.randint(90, 100)

        s = ''.join(random.choices(string.ascii_lowercase, k=length))
        arr.append(f'"{s}"')

    cases.append("[" + ",".join(arr) + "]")

output = "\n".join(cases)

pyperclip.copy(output)

print("8 formatted test cases copied to clipboard.")