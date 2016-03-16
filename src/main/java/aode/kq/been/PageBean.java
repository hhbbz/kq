package aode.kq.been;
import java.util.List;

/**
 * 自定义分页信息
 * 
 * @author lsy
 * 
 */
@SuppressWarnings("rawtypes")
public class PageBean {

	// 指定的或是页面参数
	private int page=1; // 当前页
	private int size=10; // 每页显示多少条

    private String  searchText;//搜索的文本


    private int pageOffset;	//当前位置
	// 查询数据库
	private int recordCount; // 总记录数
	private List recordList; // 本页的数据列表

	// 计算
	private int pageCount; // 总页数
	private int beginPageIndex; // 页码列表的开始索引（包含）
	private int endPageIndex; // 页码列表的结束索引（包含）

    /**
     * 排序字段
     */
    private String sort="";
    /**
     * 排序方法 ASC OR DESC
     */
	private String order="ASC";
    /**
	 * 只接受前4个必要的属性，会自动的计算出其他3个属生的值
	 * 
	 */
    public PageBean init( int recordCount, List recordList){
        this.recordCount = recordCount;
        this.recordList = recordList;

        // 计算总页码
        pageCount = (recordCount + size - 1) / size;

        // 计算 beginPageIndex 和 endPageIndex
        // >> 总页数不多于6页，则全部显示
        if (pageCount <= 6) {
            beginPageIndex = 1;
            endPageIndex = pageCount;
        }
        // >> 总页数多于6页，则显示当前页附近的共6个页码
        else {
            // 当前页附近的共6个页码（前2个 + 当前页 + 后3个）
            beginPageIndex = page - 2;
            endPageIndex = page + 3;
            // 当前面的页码不足2个时，则显示前6个页码
            if (beginPageIndex < 1) {
                beginPageIndex = 1;
                endPageIndex = 6;
            }
            // 当后面的页码不足3个时，则显示后6个页码
            if (endPageIndex > pageCount) {
                endPageIndex = pageCount;
                beginPageIndex = pageCount - 6 + 1;
            }
        }
        return this;
    }
    public PageBean(){}
	public PageBean(int page, int size, int recordCount, List recordList) {
		this.page = page;
		this.size = size;
		this.recordCount = recordCount;
		this.recordList = recordList;

		// 计算总页码
		pageCount = (recordCount + size - 1) / size;

		// 计算 beginPageIndex 和 endPageIndex
		// >> 总页数不多于6页，则全部显示
		if (pageCount <= 6) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}
		// >> 总页数多于6页，则显示当前页附近的共6个页码
		else {
			// 当前页附近的共6个页码（前2个 + 当前页 + 后3个）
			beginPageIndex = page - 2;
			endPageIndex = page + 3;
			// 当前面的页码不足2个时，则显示前6个页码
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 6;
			}
			// 当后面的页码不足3个时，则显示后6个页码
			if (endPageIndex > pageCount) {
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 6 + 1;
			}
		}
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
    public int getPageOffset() {
            return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "page=" + page +
                ", size=" + size +
                ", pageOffset=" + pageOffset +
                ", recordCount=" + recordCount +
                ", recordList=" + recordList +
                ", pageCount=" + pageCount +
                ", beginPageIndex=" + beginPageIndex +
                ", endPageIndex=" + endPageIndex +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}