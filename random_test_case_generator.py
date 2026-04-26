import json
import pyperclip

grid = [['a' if (i + j) % 2 == 0 else 'a' for j in range(500)] for i in range(500)]
output = json.dumps(grid, separators=(',', ':'))

pyperclip.copy(output)
print("Copied to clipboard.")

[
    ["b","c","d","e","a","a","a"],
    ["a","a","a","f","a","g","a"],
    ["a","h","a","a","a","i","a"],
    ["a","j","k","l","m","n","a"],
    ["a","a","a","a","a","a","a"]]