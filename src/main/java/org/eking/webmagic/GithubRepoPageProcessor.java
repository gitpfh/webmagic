
package org.eking.webmagic;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	@Override
	public void process(Page page) {
		List<String> links = page.getHtml().links().regex("(http://www\\.baikemy\\.com/disease/list/1/34\\?pageIndex=\\w+\\&pageCount\\=9)").all();
		page.addTargetRequests(links);
		page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1").toString());
		page.putField("content", page.getHtml().xpath("//li[@class='ccjb_jbli_li']/a/text()").all());
		//page.putField("tags", page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
	}

	@Override
	public Site getSite() {
		return site;

	}

	public static void main(String[] args) {
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.baikemy.com/disease/list/1/34?pageIndex=1&pageCount=9").addPipeline(new ConsolePipeline()).run();
	}
}
