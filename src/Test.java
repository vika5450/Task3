import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author - Вяткины Виктория И Ксения
 */

public class Test {
    /**
     * Поле объекта ArrayList
     */
    private ArrayList<Double> arrayList = new ArrayList<>();
    /**
     * Поле объекта LinkedList
     */
    private LinkedList<Double> linkedList = new LinkedList<>();
    /**
     * Поле для фиксации времени начала выполнения метода
     */
    private long startTime;
    /**
     * Поле для фиксации времени окончания выполнения метода
     */
    private long endTime;
    /**
     * Поле для фиксации результата
     */
    private final String result;
    /**
     * Поле для хранениния количества повторений метода
     * @param count - Количество повторений методов
     */
    private final int count;

    public Test(int count) {
        String result1;
        this.count = count;
        double TestAddArray, TestAddLinked, TestGetArray, TestGetLinked, TestDeleteArray, TestDeleteLinked;
        TestAddArray = testAddArray();
        TestAddLinked = testAddLinked();
        result1 = "Методы выполнились " + count +" раз."+ '\n'
                + "Время выполнения методов : "+ '\n'
                + "ArrayList" + '\t' + "|" + '\t' + " LinkedList "
                + '\n' + "________Метод add________ " +'\n'
                + TestAddArray + '\t' + "|" + '\t' +  TestAddLinked + '\n';
        startTime = 0;
        endTime = 0;
        TestGetArray = testGetArray();
        TestGetLinked= testGetLinked();
        result1 += "________Метод get________ "+'\n'
                + TestGetArray + '\t' + "|" + '\t' + TestGetLinked + '\n';
        startTime = 0;
        endTime = 0;
        TestDeleteArray = testDeleteArray();
        TestDeleteLinked = testDeleteLinked();
        result1 += "________Метод remove________ "+'\n'
                + TestDeleteArray + '\t' + "|" + '\t' + TestDeleteLinked + '\n'
                + "Итоги сравнения (кто быстрее) : " + '\n' + "Метод add - " + comparison(TestAddArray,  TestAddLinked) + '\n' + "Метод get - " + comparison(TestGetArray, TestGetLinked)
                + '\n' + "Метод remove - " + comparison(TestDeleteArray, TestDeleteLinked);
        result = result1;
    }

    /**
     * Метод для просмотра поля result
     *
     * @return - result
     */
    public String getResult() {
        return result;
    }

    /**
     * Метод для вычесления времени работы метода LinkedList - add
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testAddLinked() {
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.add(0.0);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода ArrayList - add
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testAddArray() {
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.add(0.0);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода ArrayList - get
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testGetArray() {
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода LinkedList - get
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testGetLinked() {
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода ArrayList - delete
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testDeleteArray() {
        startTime = System.nanoTime();
        for (int i = count - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для вычесления времени работы метода LinkedList - delete
     *
     * @return - Время работы метода (разница между оконочанием и началом работы метода)
     */
    private long testDeleteLinked() {
        startTime = System.nanoTime();
        for (int i = count - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Метод для сравнения времени работы методов
     *
     * @return - Результат сравнения
     */
    private String comparison(double array, double linked) {
        if (array < linked) {
            return "ArrayList";
        } else {
            return "LinkedList";
        }
    }
}