data = list(map(int, input().split()))

asc = [i for i in range(1,9)]

if data == asc:
  print("ascending")
elif data == sorted(asc,reverse=True):
  print("descending")
else:
  print("mixed")