fir = int(input("fir 숫자를 입력하세요"))
sec = int(input("sec 숫자를 입력하세요"))
res = 0

for i in range(fir,sec+1):
    if i%2 == 0:
        res += i
        
print("짝수의 합은 {} 입니다".format(res))