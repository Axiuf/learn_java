package org.seckill.dto;

/**
 * 暴露秒杀地址DTO
 *
 * @author Shan Cheng
 * @since 2021/4/18
 */
public class Exposer
{
    private boolean exposed;

    // 一种加密的措施
    private String md5;

    private long secKillId;

    // 系统当前时间，用于和数据库时间同步
    private long now;

    private long start;

    private long end;

    /**
     * 用于返回有效秒杀连接的情况
     *
     * @param exposed
     * @param md5
     * @param secKillId
     */
    public Exposer(boolean exposed, String md5, long secKillId)
    {
        this.exposed = exposed;
        this.md5 = md5;
        this.secKillId = secKillId;
    }

    /**
     * 用于当前不在有效秒杀时间段的情况
     *
     * @param exposed
     * @param secKillId
     * @param now
     * @param start
     * @param end
     */
    public Exposer(boolean exposed, long secKillId, long now, long start, long end)
    {
        this.exposed = exposed;
        this.secKillId = secKillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    /**
     * 用于秒杀id不存在的情况
     *
     * @param exposed
     * @param secKillId
     */
    public Exposer(boolean exposed, long secKillId)
    {
        this.exposed = exposed;
        this.secKillId = secKillId;
    }

    @Override
    public String toString()
    {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", secKillId=" + secKillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public boolean isExposed()
    {
        return exposed;
    }

    public void setExposed(boolean exposed)
    {
        this.exposed = exposed;
    }

    public String getMd5()
    {
        return md5;
    }

    public void setMd5(String md5)
    {
        this.md5 = md5;
    }

    public long getSecKillId()
    {
        return secKillId;
    }

    public void setSecKillId(long secKillId)
    {
        this.secKillId = secKillId;
    }

    public long getNow()
    {
        return now;
    }

    public void setNow(long now)
    {
        this.now = now;
    }

    public long getStart()
    {
        return start;
    }

    public void setStart(long start)
    {
        this.start = start;
    }

    public long getEnd()
    {
        return end;
    }

    public void setEnd(long end)
    {
        this.end = end;
    }
}
