---
title: Navigation组件
date: 2019-07-18 14:01:00
tags: android
categories: 组件
---

# Navigation

`Navigation`是一个可简化Android导航的库和插件。

Navigation是用来管理`Fragment`的切换，并且可以通过可视化的方式，看见App的交互流程。

## 实战

|名称|用途|
|:--:|:--:|
|Navigation graph|XML资源文件，包含所有的navigation关联信息，用户在可视化界面可以看出他能够到达的`destination`，以及流程关系|
|NavHost|在navigation graph展示`destination`的空容器，NavHostFragment为展示fragment destination的具体实现|
|NavController|导航控制者|

### 创建Navigation graph

```xml
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/nav_graph"
    app:startDestination="@id/tasks_fragment_dest">

</navigation>
```

### 新建`NavHostFragment`

```xml
 <fragment
            android:id="@+id/nav_host_fragment"
            android:name="androidx.navigation.fragment.NavHostFragment" //值是固定的，声明这是一个NavHostFragment
            android:layout_width="match_parent"
            android:layout_height="match_parent"

            app:defaultNavHost="true" //与系统的返回按钮相关联
            app:navGraph="@navigation/nav_graph"//存放Navigation graph
             />

```

### 界面跳转、参数传递和动画

#### 利用id导航

```kotlin
fun Fragment.findNavController(): NavController =
        NavHostFragment.findNavController(this)
```

```kotlin
btnLogin.setOnClickListener {
            // 设置动画参数
            val navOption = navOptions {
                anim {
                    enter = R.anim.slide_in_right
                    exit = R.anim.slide_out_left
                    popEnter = R.anim.slide_in_left
                    popExit = R.anim.slide_out_right
                }
            }
            // 参数设置
            val bundle = Bundle()
            bundle.putString("name","TeaOf")
            findNavController().navigate(R.id.login, bundle,navOption)
}
```

#### 利用`Safe Args`

action标签：

|属性|作用|
|:--:|:--:|
|app:destination|跳转完成到达的`fragment`的id|
|app:popUpTo|将fragment从栈中弹出，直到某个Id的fragment|

argument标签：

|属性|作用|
|android:name|标签名字|
|app:argType|标签的类型|
|android:defaultValue|默认值|

```xml
<fragment
    android:id="@+id/tasks_fragment_dest"
    android:name="com.example.android.architecture.blueprints.todoapp.tasks.TasksFragment"
    android:label="@string/app_name">
    <action
        android:id="@+id/action_tasksFragment_to_statisticsFragment"
        app:destination="@id/statistics_fragment_dest" />
    <action
        android:id="@+id/action_tasksFragment_to_taskDetailFragment"
        app:destination="@id/task_detail_fragment_dest" />
    <action
        android:id="@+id/action_tasksFragment_to_addEditTaskFragment"
        app:destination="@id/add_edit_task_fragment_dest" />
    <argument
        android:name="userMessage"
        app:argType="integer"
        android:defaultValue="0" />
</fragment>
```

自动生成两个文件：

```kotlin
class TasksFragmentDirections private constructor() {
    private data class ActionTasksFragmentToTaskDetailFragment(val taskId: String) : NavDirections {
        override fun getActionId(): Int = R.id.action_tasksFragment_to_taskDetailFragment

        override fun getArguments(): Bundle {
            val result = Bundle()
            result.putString("taskId", this.taskId)
            return result
        }
    }

    private data class ActionTasksFragmentToAddEditTaskFragment(val taskId: String?, val title:
            String) : NavDirections {
        override fun getActionId(): Int = R.id.action_tasksFragment_to_addEditTaskFragment

        override fun getArguments(): Bundle {
            val result = Bundle()
            result.putString("taskId", this.taskId)
            result.putString("title", this.title)
            return result
        }
    }

    companion object {
        fun actionTasksFragmentToStatisticsFragment(): NavDirections =
                ActionOnlyNavDirections(R.id.action_tasksFragment_to_statisticsFragment)

        fun actionTasksFragmentToTaskDetailFragment(taskId: String): NavDirections =
                ActionTasksFragmentToTaskDetailFragment(taskId)

        fun actionTasksFragmentToAddEditTaskFragment(taskId: String?, title: String): NavDirections
                = ActionTasksFragmentToAddEditTaskFragment(taskId, title)
    }
}

```

你还是得写点击事件来完成导航：

```kotlin
clsss TasksFragment : Fragment() {
    private val args: TasksFragmentArgs by navArgs();
}
```

## 总结

![navigation总结](navigation_总结.webp)
