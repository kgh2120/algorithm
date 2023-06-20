import sys

n = int(sys.stdin.readline())

for i in range(n):
  r, word = sys.stdin.readline().strip().split()
  data = ""
  for j in range(len(word)):
    data += word[j] * int(r)
  print(data)