import sys

n = int(sys.stdin.readline().strip())

for i in range(n):
  a,b = map(int, sys.stdin.readline().strip().split())
  print(f"Case #{i+1}: {a+b}")