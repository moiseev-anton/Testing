from average_comparator import AverageComparator

if __name__ == '__main__':

    nums1 = list(map(float, input("Список 1. Введите числа через пробел: ").split()))
    nums2 = list(map(float, input("Список 2. Введите числа через пробел: ").split()))

    try:
        result = AverageComparator.compare_lists(nums1, nums2)
        print(result)
    except Exception as e:
        print(e)
