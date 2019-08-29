#this function finds if there is a subset of integers of the array arr
#which have sum equals zero
#
#sub-problem: opt(i,j) = True if there is a subset of arr[0:j] with sum equals i
#else opt(i,j) = False

def existSubsetWithSumZero(arr):
    minSum = maxSum = 0
    for number in arr:
        if number < 0:
            minSum += number
        else:
            maxSum += number
    
    opt = []
    for i in range(len(arr)):
        tmp = []
        for j in range(abs(minSum) + maxSum + 1):
            tmp.append(False)
        opt.append(tmp)

    for i in range(len(opt[0])):
        if i == abs(-minSum + arr[0]):
            opt[0][i] = True
            break

    for j in range(1,len(arr)):
        for i in range(len(opt[0])):
            if opt[j-1][i] == True:#arr[0:j] includes arr[0:j-1]
                opt[j][i] = True
            else:
                if arr[j] == minSum + i:
                    opt[j][i] = True
                elif i - arr[j] < 0 or minSum + i - arr[j] > maxSum:
                    opt[j][i] = False
                else:
                    opt[j][i] = opt[j-1][i - arr[j]]
    
    return opt[len(arr) - 1][abs(minSum)]
