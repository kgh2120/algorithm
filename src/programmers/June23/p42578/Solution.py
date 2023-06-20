def solution(clothes):
  map = {}
  answer = 1

  for name, type in clothes:
    map[type] = map.get(type,0) + 1

  for type in map:
    answer *= (map[type]+1)
  return answer-1