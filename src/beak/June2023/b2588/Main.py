import sys

a = int(sys.stdin.readline())
b = sys.stdin.readline().strip()


for i in reversed(range(len(b))):
  print(a * int(b[i]))

print(a*int(b))