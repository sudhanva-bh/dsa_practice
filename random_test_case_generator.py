import pyperclip

# Max constraints
m, n = 300, 300
grid = []

# Generate a continuous snake path covering the entire grid
for r in range(m):
    # Default to horizontal streets
    row = [1] * n
    
    if r == 0:
        # First row: straight right, then turn down at the end
        row[-1] = 3
    elif r == m - 1:
        # Last row: accept from top at the very end
        row[-1] = 2
    elif r % 2 == 1:
        # Odd rows: moving right-to-left
        row[0] = 4  # Turn down at the left edge
        row[-1] = 5 # Accept from top at the right edge
    else:
        # Even rows: moving left-to-right
        row[0] = 6  # Accept from top at the left edge
        row[-1] = 3 # Turn down at the right edge
        
    grid.append(row)

# Format into a single continuous line: [[1,2...],[1,3...]...]
one_line_testcase = "[" + ",".join("[" + ",".join(map(str, row)) + "]" for row in grid) + "]"

# Copy to clipboard
pyperclip.copy(one_line_testcase)
print(f"Success! {m}x{n} grid test case copied to clipboard. Ready to paste into LeetCode.")