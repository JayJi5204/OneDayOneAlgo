class bubleSort:
    def __init__(self):
        pass
    def sort(self, arr, reverse=False):
        n = len(arr)
        for i in range(n):
            for j in range(n):
                if reverse:
                    if arr[i] > arr[j]:
                        arr[i], arr[j] = arr[j], arr[i]
                else:
                    if arr[i] < arr[j]:
                        arr[i], arr[j] = arr[j], arr[i]
        return arr