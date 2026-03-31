import pyperclip
import random

MAX_CELLS = 10**5

def generate_random_dimensions():
    # Pick total size first (ensures constraint)
    total = random.randint(9 * 10**4, MAX_CELLS)

    # Find a random divisor pair (m, n)
    m = random.randint(1, total)
    while total % m != 0:
        m = random.randint(1, total)

    n = total // m
    return m, n

def generate_grid(m, n):
    return [[random.randint(1, 10**5) for _ in range(n)] for _ in range(m)]

def grid_to_string(grid):
    return "[\n" + ",\n".join(str(row) for row in grid) + "\n]"

# Generate random valid dimensions
m, n = generate_random_dimensions()
grid = generate_grid(m, n)

grid_str = grid_to_string(grid)
pyperclip.copy(grid_str)

print(f"Copied grid with m={m}, n={n}, total={m*n}")