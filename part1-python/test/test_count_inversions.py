# coding=utf-8

from unittest import TestCase

from week1.count_inversions import count_inversions


class TestCountInversions(TestCase):
    def test_count_empty_array(self):
        self.assertEqual(0, count_inversions([]))

    def test_count(self):
        a = [3, 2]
        n = count_inversions(a)
        self.assertEqual(1, n)
        self.assertEquals([2, 3], a)

        a = [54044, 14108, 79294, 29649, 25260]
        n = count_inversions(a)
        self.assertEquals([14108, 25260, 29649, 54044, 79294], a)
        self.assertEquals(6, n)
