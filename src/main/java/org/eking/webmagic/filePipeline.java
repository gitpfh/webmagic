
package org.eking.webmagic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class filePipeline implements Pipeline {

	@SuppressWarnings("unchecked")
	@Override
	public void process(ResultItems resultItems, Task task) {
		//遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
		try {
			FileWriter fwRel = new FileWriter("D:/medical/rdf/name.txt", true);
			for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
				for (String str : (ArrayList<String>) entry.getValue()) {
					fwRel.write(str + "\r\n");
				}
				System.out.println(entry.getKey() + ":\t" + entry.getValue());
			}
			fwRel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
