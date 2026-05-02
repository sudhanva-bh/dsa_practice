import random
import pyperclip

n = 10**5
choices = ['L', 'R', 'S']

# Generate random directions string
directions = ''.join(random.choices(choices, k=n))

# Copy to clipboard
pyperclip.copy(directions)

print("Copied to clipboard. Length:", len(directions))