import sys

read = sys.stdin.readline

a,b,c = map(int, read().split())

print((a+b)%c)
print(((a%c) + (b%c))%c)
print((a*b)%c)
print(((a%c) * (b%c))%c)
