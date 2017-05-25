
package org.eking.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	@Override
	public void process(Page page) {
		//List<String> links = page.getHtml().links().regex("(http://www\\.a\\-hospital\\.com/w/疾病条目索引\\-[a-zA-Z])").all();
		//page.addTargetRequests(links);
		//page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1").toString());
		page.putField("content", page.getHtml().xpath("//div[@id='bodyContent']/ul/li/a/text()").all());
		//page.putField("tags", page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
	}

	@Override
	public Site getSite() {
		return site;

	}

	public static void main(String[] args) {
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-A").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-B").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-C").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-D").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-E").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-F").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-G").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-H").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-J").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-K").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-L").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-M").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-N").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-O").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-P").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-Q").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-R").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-S").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-T").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-W").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-X").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-Y").addPipeline(new FilePipeline()).run();
		Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.a-hospital.com/w/疾病条目索引-Z").addPipeline(new FilePipeline()).run();
	}
}
