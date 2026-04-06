import pyperclip

thousands = ["", "M", "MM", "MMM"]
hundreds  = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
tens      = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
ones      = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]

res = []

for i in range(4000):
    roman = (
        thousands[i // 1000] +
        hundreds[(i % 1000) // 100] +
        tens[(i % 100) // 10] +
        ones[i % 10]
    )
    res.append(f"\"{roman}\"")

lines = []
for i in range(0, len(res), 100):
    chunk = res[i:i+100]
    lines.append(", ".join(chunk))

java_array = "{\n" + ",\n".join(lines) + "\n}"

pyperclip.copy(java_array)

print("Copied to clipboard!")