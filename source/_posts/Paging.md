---
title: Paging
date: 2019-07-23 12:28:33
tags: 组件
---

# Paging

## 介绍

```text
The Paging Library helps you load and display small chunks of data at a time.Loading partial data on demand reduces usage of network bandwidth and system
```

处理大量数据的处理方法：

1. 借助刷新控件实现用户手动请求数据。
2. 数据到达边界自动请求加载。

|名称|作用|
|:--:|:--:|
|PagedList|一个可以以分页形式异步加载数据的容器，可以跟`RecyclerView`很好的结合|
|DataSource或DataSource.Factory|数据源，`DataSource`将数据转换为PagedList，`DataSource.Factory`则用来创建`DataSource`|
|`LivePagedListBuilder`|用来生成`LiveData<PagedList>`，需要`DataSource.Factory`参数|
|`BoundaryCallback`|数据到达边界的回调|
|`PagedListAdapter`|一种RecyclerView的适配器|

### 优点

- `RxJava 2`以及`Android Jetpack`的支持，如`LiveData`、`Room`。
- 自定义分页策略。
- 异步处理数据。
- 结合RecyclerView等

## 实战

### 创建数据源

#### 1.非Room数据库

|名称|使用场景|
|:--:|:--:|
|`PageKeyedDataSource<Key, Value>`|分页请求数据的场景|
|`ItemKeyedDataSource<Key, Value>`|以表的某个列为key，加载其后的N个数据|
|`PositionalDataSource<T>`|以数据源总数特定，根据指定位置请求数据的场景|

#### 2.Room数据库

如果是使用`Room`与Paging结合的方式呢

```java
@Dao
interface  CheeseDao {
    @Query("SELECT * FROM Cheese ORDER BY name COLLATE NOCASE ASC")
    fun allCheesedByName() : DataSource.Factory<Int, Cheese>
}
```

### 构建`LiveData<PagedList>`

```java
val allCheeses = dao.allCheesesByName().toLiveData(Config) (pageSize = 30, 
            enablePlaceholders = true,
                maxSize = 200)
```

### 创建PagedListAdapter

```java
class CheeseAdapter : PagedListAdapter<Cheese, CheeseViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: CheeseViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheeseViewHolder = CheeseViewHolder(parent)

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Cheese>() {
            override fun areItemsTheSame(oldItem: Cheese, newItem: Cheese): Boolean =
                    oldItem.id == newItem.id

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: Cheese, newItem: Cheese): Boolean =
                    oldItem == newItem
        }
    }
}
```