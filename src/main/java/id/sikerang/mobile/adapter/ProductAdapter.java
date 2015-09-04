package id.sikerang.mobile.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.Bind;
import butterknife.ButterKnife;
import id.sikerang.mobile.R;
import id.sikerang.mobile.SiKerang;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class ProductAdapter extends PagerAdapter implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private final LayoutInflater mLayoutInflater;
    private final AtomicInteger mPosition;
    private final Map<Integer, ProductViewHolder> mHoldersMap;

    public ProductAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mPosition = new AtomicInteger();
        mHoldersMap = new HashMap<>();
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (!mHoldersMap.containsKey(position)) {
            mHoldersMap.put(position, new ProductViewHolder(position, mLayoutInflater, container));
        }
        ProductViewHolder viewHolder = mHoldersMap.get(position);
        container.addView(viewHolder.getView());

        return viewHolder.getView();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    @Override
    public void onClick(View view) {
        ProductViewHolder viewHolder = mHoldersMap.get(mPosition.get());
        viewHolder.onClick(view);
    }

    @Override
    public void onPageSelected(int position) {
        mPosition.set(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    static final class ProductViewHolder implements View.OnClickListener {
        private final View mView;

        @Bind(R.id.iv_product)
        ImageView mImageViewProduct;

        @Bind(R.id.tv_product)
        TextView mTextViewProduct;

        @Bind(R.id.tv_statement)
        TextView mTextViewStatment;

        @Bind(R.id.btn_price)
        Button mButtonPrice;

        @Bind(R.id.btn_location)
        Button mButtonLocation;

        public ProductViewHolder(final int position, final LayoutInflater layoutInflater, final ViewGroup container) {
            mView = layoutInflater.inflate(R.layout.fragment_product, container, false);
            ButterKnife.bind(this, mView);
            initView(position);
        }

        @Override
        public void onClick(View view) {
            final int color;
            final int text;

            switch (view.getId()) {
                case R.id.btn_likes: {
                    color = R.color.teal_500;
                    text = R.string.text_likes;
                    break;
                }
                case R.id.btn_dislikes: {
                    color = R.color.red_500;
                    text = R.string.text_dislikes;
                    break;
                }
                default: {
                    return;
                }
            }

            getTextViewStatment().setTextColor(SiKerang.getContext().getResources().getColor(color));
            getTextViewStatment().setText(SiKerang.getContext().getResources().getString(text));
        }

        private void initView(int position) {
            switch (position) {
                case 0: {
                    getImageViewProduct().setBackgroundDrawable(SiKerang.getContext().getResources().getDrawable(R.mipmap.ic_rice));
                    getTextViewProduct().setText(SiKerang.getContext().getResources().getString(R.string.product_rice));
                    getButtonPrice().setText(SiKerang.getContext().getResources().getString(R.string.price_rice));
                    getButtonLocation().setText(SiKerang.getContext().getResources().getString(R.string.text_location));
                    break;
                }
                case 1: {
                    getImageViewProduct().setBackgroundDrawable(SiKerang.getContext().getResources().getDrawable(R.mipmap.ic_corn));
                    getTextViewProduct().setText(SiKerang.getContext().getResources().getString(R.string.product_corn));
                    getButtonPrice().setText(SiKerang.getContext().getResources().getString(R.string.price_corn));
                    getButtonLocation().setText(SiKerang.getContext().getResources().getString(R.string.text_location));
                    break;
                }
                case 2: {
                    getImageViewProduct().setBackgroundDrawable(SiKerang.getContext().getResources().getDrawable(R.mipmap.ic_soya));
                    getTextViewProduct().setText(SiKerang.getContext().getResources().getString(R.string.product_soya));
                    getButtonPrice().setText(SiKerang.getContext().getResources().getString(R.string.price_soya));
                    getButtonLocation().setText(SiKerang.getContext().getResources().getString(R.string.text_location));
                    break;
                }
                case 3: {
                    getImageViewProduct().setBackgroundDrawable(SiKerang.getContext().getResources().getDrawable(R.mipmap.ic_chicken));
                    getTextViewProduct().setText(SiKerang.getContext().getResources().getString(R.string.product_chicken));
                    getButtonPrice().setText(SiKerang.getContext().getResources().getString(R.string.price_chicken));
                    getButtonLocation().setText(SiKerang.getContext().getResources().getString(R.string.text_location));
                    break;
                }
                case 4: {
                    getImageViewProduct().setBackgroundDrawable(SiKerang.getContext().getResources().getDrawable(R.mipmap.ic_meal));
                    getTextViewProduct().setText(SiKerang.getContext().getResources().getString(R.string.product_meal));
                    getButtonPrice().setText(SiKerang.getContext().getResources().getString(R.string.price_meal));
                    getButtonLocation().setText(SiKerang.getContext().getResources().getString(R.string.text_location));
                    break;
                }
                case 5: {
                    getImageViewProduct().setBackgroundDrawable(SiKerang.getContext().getResources().getDrawable(R.mipmap.ic_sugar));
                    getTextViewProduct().setText(SiKerang.getContext().getResources().getString(R.string.product_sugar));
                    getButtonPrice().setText(SiKerang.getContext().getResources().getString(R.string.price_sugar));
                    getButtonLocation().setText(SiKerang.getContext().getResources().getString(R.string.text_location));
                    break;
                }
            }
        }

        public View getView() {
            return mView;
        }

        public ImageView getImageViewProduct() {
            return mImageViewProduct;
        }

        public TextView getTextViewProduct() {
            return mTextViewProduct;
        }

        public TextView getTextViewStatment() {
            return mTextViewStatment;
        }

        public Button getButtonPrice() {
            return mButtonPrice;
        }

        public Button getButtonLocation() {
            return mButtonLocation;
        }
    }
}