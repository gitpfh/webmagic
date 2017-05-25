
package org.eking.webmagic;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

	private Site site = Site.me().setCycleRetryTimes(5).setSleepTime(100).setTimeOut(50000);

	@Override
	public void process(Page page) {
		List<String> links = page.getHtml().$("div#bodyContent a", "href").all();

		for (String link : links) {
			if (link.matches(".*//www\\.a-hospital\\.com/w/%E7%96%BE%E7%97%85%E6%9D%A1%E7%9B%AE%E7%B4%A2%E5%BC%95-[a-zA-Z]")) {
				Request request = new us.codecraft.webmagic.Request(link);
				page.addTargetRequest(request);
			}
		}
		//page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1").toString());
		page.putField("content", page.getHtml().xpath("//div[@id='bodyContent']/ul/li/a/text()").all());
		//page.putField("tags", page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
	}

	@Override
	public Site getSite() {
		return site;

	}

	public static void main(String[] args) {
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://baike.baidu.com/item/皮肤滤泡中心淋巴瘤").addPipeline(new FilePipeline()).thread(10).run();
	}
}
