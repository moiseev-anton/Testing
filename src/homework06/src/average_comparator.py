""" Модуль для сравнения средних значений списков чисел."""
class AverageComparator:
    """Класс для сравнения средних значений списков чисел."""

    @staticmethod
    def find_average(nums: list) -> float:
        """
        Вычисляет среднее значение списка чисел.

       Args:
           nums (list): Список чисел для вычисления среднего значения.

       Raises:
           TypeError: Если переданный объект не является списком.
           ValueError: Если список содержит элементы, не являющиеся числами.

       Returns:
           float: Среднее значение чисел в списке.
       """
        if not isinstance(nums, list):
            raise TypeError("Переданный объект не является списком")
        if not nums:
            return 0
        if not all(isinstance(num, (int, float)) for num in nums):
            raise ValueError("Список содержит элементы, не являющиеся числами")
        return sum(nums) / len(nums)

    @staticmethod
    def compare_lists(nums1: list, nums2: list):
        """
        Сравнивает средние значения двух списков чисел и возвращает
        соответствующее сообщение.

        Args:
            nums1 (list): Первый список чисел.
            nums2 (list): Второй список чисел.

        Returns:
            str: Сообщение о результатах сравнения средних значений списков.
        """
        avg1 = AverageComparator.find_average(nums1)
        avg2 = AverageComparator.find_average(nums2)

        if avg1 > avg2:
            return "Первый список имеет большее среднее значение"
        if avg1 < avg2:
            return "Второй список имеет большее среднее значение"
        return "Средние значения равны"
