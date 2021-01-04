package src.test;

public class Test2 {

//    Q. Given two numbers a & b, we need to find the greatest number that can divide both a & b
//    ex:- 12, 8  => 4
    public static void main(String[] args) {
//        Emp - > sal, dept
//        select  name from emp as e join
//        (select department, max(salary) as sal from emp as e1 join (select department, max(salary)  as sal from emp group by department) as deTemp
//         on deTemp.deparmtent=e1.department group by department having max(salary) <> deTemp.salary ) as de
//        on de.department=e.department and de.salary = e.salary ;


//        (select department, max(salary) as sal from emp as e1 join (select department, max(salary)  as sal from emp group by department) as deTemp
//         on deTemp.deparmtent=e1.department group by department having max(salary) <> deTemp.salary ) as de


        int a = 12, b = 8;

        while (b>0) {
            if (b==0) {
                break;
            }
            int temp = b;
            b = a%b;
            a = temp;
        }
        System.out.println(a);

        int res = Test2.gcd(a,b);
        System.out.println(res);
    }

    private static int gcd(int a, int b) {
        if (b==0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
