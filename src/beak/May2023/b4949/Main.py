while True:
  words = input()
  if words == ".":
    break;

  prev = []
  count = 0
  isPass = True;
  for i in range(len(words)):
    c = words[i]
    if c == "(":
      count += 1
      prev.append("(")
    elif c == "[":
      count +=1
      prev.append("[")
    elif c == ")":
      if(len(prev) == 0):
        isPass = False;
        break;
      if(prev.pop() == "("):
        count -=1
      else:
        isPass = False;
        break;
    elif c == "]":
      if(len(prev) == 0):
        isPass = False;
        break;

      if(prev.pop() == "["):
        count -=1
      else:
        isPass = False;
        break;

  if(isPass and count == 0):
    print("yes")
  else:
    print("no")