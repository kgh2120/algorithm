def solution(participant, completion):

  answer = ''
  dd = {}

  for p in participant:
    if(dd.get(p)):
      dd[p] +=1
    else:
      dd[p] = 1

  for c in completion:
    dd[c] -= 1
  # 음.. value가 1인 애를 찾아서 리턴해줘야 함
  for key in dd.keys():
    if(dd[key]==1):
      answer = key
      break

  return answer