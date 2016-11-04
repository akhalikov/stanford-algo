# coding=utf-8

from unittest import TestCase

from week1.count_inversions import CountInversions


class TestCountInversions(TestCase):

    def test_count_empty_array(self):
        self.assertEqual(0, CountInversions.count([]))

    def test_count(self):
        numbers = [3, 2]
        self.assertEqual(1, CountInversions.count(numbers))
