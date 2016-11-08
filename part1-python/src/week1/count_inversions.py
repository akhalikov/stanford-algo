# coding=utf-8
import sys


def count_inversions(arr):
    if arr is None:
        raise ValueError("numbers should not be None")

    if len(arr) < 2:
        return 0

    def _sync_tmp(first, last):
        for i in range(first, last):
            tmp_arr[i] = arr[i]

    def _merge_and_count(first, mid, last):
        i, j, count_inv = first, mid, 0
        _sync_tmp(first, last)

        for k in range(first, last):
            if i >= mid:
                arr[k] = tmp_arr[j]
                j += 1
            elif j >= last:
                arr[k] = tmp_arr[i]
                i += 1
            elif tmp_arr[j] < tmp_arr[i]:
                arr[k] = tmp_arr[j]
                j += 1
                count_inv += mid - i
            else:
                arr[k] = tmp_arr[i]
                i += 1

        return count_inv

    def _sort_and_count(first, last):
        if last - first <= 1:
            return 0

        mid = (first + last) // 2

        count = _sort_and_count(first, mid)
        count += _sort_and_count(mid, last)
        count += _merge_and_count(first, mid, last)

        return count

    tmp_arr = [0] * len(arr)
    return _sort_and_count(0, len(arr))


def file2list(filename):
    with open(filename, 'r') as inp:
        return [int(line) for line in inp]


def main():
    if len(sys.argv) < 2:
        print("input file name expected")
    else:
        numbers = file2list(sys.argv[1])
        n = count_inversions(numbers)
        print("number of inversions is: ", n)


if __name__ == "__main__":
    main()
