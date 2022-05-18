package test;

public class SyntheticMethodDemo {

    class NestedClass {
        private String nestedField;
        private Integer a;

        public String getNestedField() {
            return nestedField;
        }

        public void setNestedField(String nestedField) {
            this.nestedField = nestedField;
        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }
    }

    public String getNestedField() {
        return new NestedClass().nestedField;
    }

    public void setNestedField(String nestedField) {
        new NestedClass().nestedField = nestedField;
    }
    public void test(){
        NestedClass nestedClass = new NestedClass();
        nestedClass.setA(11);
        System.out.println(nestedClass.a);
    }
}
