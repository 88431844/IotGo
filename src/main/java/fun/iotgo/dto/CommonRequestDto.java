package fun.iotgo.dto;

/**
 * @Author miracle
 * @Date 2017/9/18 0018 14:38
 */
public class CommonRequestDto {
    //每页页数
    private long pageSize;
    //第几页
    private long pageIndex;
    //是否需要分页
    boolean needPage;

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public boolean isNeedPage() {
        return needPage;
    }

    public void setNeedPage(boolean needPage) {
        this.needPage = needPage;
    }
}
