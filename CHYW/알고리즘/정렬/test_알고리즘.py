#pytest
from 버블정렬 import bubleSort

def test_bubleSort():
    sorter = bubleSort()
    
    arr = [64, 34, 25, 12, 22, 11, 90]
    sorted_arr = [11, 12, 22, 25, 34, 64, 90]
    assert sorter.sort(arr.copy()) == sorted_arr

    arr_desc = [64, 34, 25, 12, 22, 11, 90]
    sorted_arr_desc = [90, 64, 34, 25, 22, 12, 11]
    assert sorter.sort(arr_desc.copy(), reverse=True) == sorted_arr_desc