# coding=utf-8


class CountInversions:
    def __init__(self):
        pass

    @staticmethod
    def count(numbers):
        if len(numbers) == 0:
            return 0

        def _sort_and_count_inv(a, first, last):
            if first > last:
                return

            mid = first + (last - first) / 2

            x = _sort_and_count_inv(a, first, mid)
            y = _sort_and_count_inv(a, mid + 1, last)

            tmp = [i for i in a]
            k, f, l = first, first, mid + 1
            inversions = x + y

            while k < last:
                if l >= mid:
                    a[k] = tmp[l]
                    l += 1
                elif l >= last:
                    a[k] = tmp[f]
                    f += 1
                elif tmp[l] < tmp[f]:
                    a[k] = tmp[l]
                    l += 1
                    inversions += 1
                else:
                    a[k] = tmp[f]
                    f += 1

            return inversions

        return _sort_and_count_inv(numbers, 0, len(numbers) - 1)