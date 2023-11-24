from unittest import TestCase
from unittest.mock import patch

from pytest import raises

from homework06.src.average_comparator import AverageComparator as ac


class TestAverageComparator(TestCase):
    """Класс для тестирования методов класса AverageComparator."""

    def test_find_average(self):
        """Тест проверяет корректность вычисления среднего значения списка чисел"""
        assert ac.find_average([1, 2, 3]) == 2.0
        assert ac.find_average([5]) == 5

    def test_find_average_of_empty_list(self):
        """Тест проверяет корректность вычисления среднего значения пустого списка чисел"""
        assert ac.find_average([]) == 0

    def test_find_average_wrong_arg_type(self):
        """Тест проверяет появление исключения TypeError если передан аргумент неправильного типа"""
        with raises(TypeError):
            ac.find_average("text")

    def test_find_average_not_num_item(self):
        """Тест проверяет появление исключения ValueError если переданый список содержит не число"""
        with raises(ValueError):
            ac.find_average([1, 'a'])

    def test_compare_lists_equal_averages(self):
        """Тест проверяет корректность работы когда средние значения списков равны
        для изолированного метода compare_lists
        """
        with patch.object(ac, "find_average", side_effect=[2, 2]) as mock_find_average:
            result = ac.compare_lists([1, 2, 3], [4, 5, 6])
            assert result == "Средние значения равны"
            mock_find_average.assert_any_call([1, 2, 3])
            mock_find_average.assert_any_call([4, 5, 6])

    def test_compare_lists_first_greater(self):
        """Тест проверяет корректность работы когда среднее значение первого списка больше
        для изолированного метода compare_lists
        """
        with patch.object(ac, "find_average", side_effect=[3, 2]) as mock_find_average:
            result = ac.compare_lists([1, 2, 3], [4, 5, 6])
            assert result == "Первый список имеет большее среднее значение"
            mock_find_average.assert_any_call([1, 2, 3])
            mock_find_average.assert_any_call([4, 5, 6])

    def test_compare_lists_second_greater(self):
        """
        Тест проверяет корректность работы когда среднее значение второго списка больше
        для изолированного метода compare_lists
        """
        with patch.object(ac, "find_average", side_effect=[2, 3]) as mock_find_average:
            result = ac.compare_lists([1, 2, 3], [4, 5, 6])
            assert result == "Второй список имеет большее среднее значение"
            mock_find_average.assert_any_call([1, 2, 3])
            mock_find_average.assert_any_call([4, 5, 6])

    def test_integration_compare_lists_equal_averages(self):
        """Иитеграционный тест проверяет корректность работы когда средние значения списков равны"""
        result = ac.compare_lists([1, 2, 3], [-1, 5])
        assert result == "Средние значения равны"

    def test_integration_compare_lists_first_greater(self):
        """
        Иитеграционный тест проверяет корректность работы когда
        среднее значение первого списка больше
        """
        result = ac.compare_lists([4, 2, 3], [-1, 5])
        assert result == "Первый список имеет большее среднее значение"

    def test_integration_compare_lists_second_greater(self):
        """
        Иитеграционный тест проверяет корректность работы когда среднее
        значение второго списка больше
        """
        result = ac.compare_lists([1, 2, 3], [1, 5])
        assert result == "Второй список имеет большее среднее значение"

    def test_integration_compare_lists_wrong_arg_type(self):
        """
        Иитеграционный тест проверяет появление исключения TypeError
        если передан аргумент неправильного типа
        """
        with raises(TypeError):
            ac.compare_lists("text", [1, 5])

    def test_integration_compare_lists_not_num_item(self):
        """
        Иитеграционный тест проверяет появление исключения ValueError
        если переданый список содержит не число"
        """
        with raises(ValueError):
            ac.compare_lists([1, 'a'], [1, 5])
