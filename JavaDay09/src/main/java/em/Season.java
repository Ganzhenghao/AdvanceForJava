package em;

/**
 * 季节
 *
 * @ClassName Season
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/27 20:05
 * @Version 1.0
 */
public enum Season {
    /**
     * @see Season 春天
     */
    Spring("春"),
    /**
     * @see Season 夏天
     */
    Summer("夏"),
    /**
     * @see Season 秋天
     */
    Autumn("秋"),
    /**
     * @see Season 冬天
     */
    Winter("冬");

    /**
     * @see String 价值
     */
    private final String value;

    /**
     * 季节
     *
     * @param value 价值
     * @Return {@link  }
     * @Author Ganzhenghao
     * @Date 2021/03/11 20:33:62
     **/
    Season(String value) {
        this.value = value;
    }

    /**
     * 获得的价值
     *
     * @Return {@link String }
     * @Author Ganzhenghao
     * @Date 2021/03/11 20:33:74
     **/
    public String getValue() {
        return value;
    }
}
