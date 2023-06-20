def solution(arr):
  answer = []
  for i in arr:
    if answer:
      if i == answer[-1]:
        continue
      else:
        answer.append(i)
    else:
      answer.append(i)
  return answer