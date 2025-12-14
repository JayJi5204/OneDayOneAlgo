#pytest
def test_bubleSort():
    from 버블정렬 import bubleSort
    sorter = bubleSort()
    
    arr = [64, 34, 25, 12, 22, 11, 90]
    sorted_arr = [11, 12, 22, 25, 34, 64, 90]
    assert sorter.sort(arr.copy()) == sorted_arr

    arr_desc = [64, 34, 25, 12, 22, 11, 90]
    sorted_arr_desc = [90, 64, 34, 25, 22, 12, 11]
    assert sorter.sort(arr_desc.copy(), reverse=True) == sorted_arr_desc

def test_insertionSort():
    from 삽입정렬 import InsertionSort
    sorter = InsertionSort()

    arr = [64, 34, 25, 12, 22, 11, 90]
    sorted_arr = [11, 12, 22, 25, 34, 64, 90]
    assert sorter.sort(arr.copy()) == sorted_arr

    arr_desc = [64, 34, 25, 12, 22, 11, 90]
    sorted_arr_desc = [90, 64, 34, 25, 22, 12, 11]
    assert sorter.sort(arr_desc.copy(), revserse=True) == sorted_arr_desc

def test_selectionSort():
    from 선택정렬 import SelectionSort
    sorter = SelectionSort()

    arr = [64, 34, 25, 12, 22, 11, 90]
    sorted_arr = [11, 12, 22, 25, 34, 64, 90]
    assert sorter.sort(arr.copy()) == sorted_arr