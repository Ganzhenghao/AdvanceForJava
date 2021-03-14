package enu.bean;

import lombok.Getter;

/**
 * @ClassName Season
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/11 15:08
 * @Version 1.0
 */
@Getter
public enum Season {
    /**
     * @see Season 春天
     */
    SPRING("春天"){
        @Override
        void show() {

        }
    },
    /**
     * @see Season 夏天
     */
    SUMMER("夏") {
        @Override
        void show() {

        }
    },
    /**
     * @see Season 秋天
     */
    AUTUMN("秋") {
        @Override
        void show() {

        }
    },
    /**
     * @see Season 冬天
     */
    WINTER("冬") {
        @Override
        void show() {

        }
    };

    private final String value;

    private Season(String value) {
        this.value = value;
    }

    abstract void show();

    private void say(){
        System.out.println("我是"+getValue()+"天");
    }

}
