import pyperclip
import json

def generate_worst_case():
    width = 100
    height = 100

    ops = ["Robot"]
    args = [[width, height]]

    q = 10000

    for i in range(q):
        if i % 3 == 0:
            ops.append("getPos")
            args.append([])
        elif i % 3 == 1:
            ops.append("getDir")
            args.append([])
        else:
            ops.append("step")
            args.append([100000])

    return ops, args

ops, args = generate_worst_case()

output = json.dumps(ops) + "\n" + json.dumps(args)
pyperclip.copy(output)

print("Worst-case copied to clipboard:\n")
print(output)