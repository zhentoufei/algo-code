


def fib(n):
    fib_dcit = {}
    return dp(n, fib_dcit)

def dp(n, fib_dcit):

    if(n in fib_dcit.keys()):
        return fib_dcit[n]
    elif(n < 2):
        fib_dcit[n] = n
    else:
        fib_dcit[n] = fib(n - 1) + fib(n - 2)
    return fib_dcit[n]

def fib2(n):
    if(n <= 1):
        return n
    pre = 1
    cur = 1
    for i in range(3, n):
        tmp = cur
        cur = pre + cur
        pre = tmp
    return cur


if __name__ == '__main__':
    # print(fib(4))
    for i in range(2,10):
        print(i)